(ns advent-of-code-2017.day07
  (:require [clojure.string             :as    str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int,
                                                elem]]))

(defn node-of [xs]
  (let [[a b] (str/split (apply str (take-while #(not= % \)) xs)) #" ")]
    [a (string->int b)]))

(defn edges [xs]
  (let [x  (first (str/split xs #" "))
        ns1 (apply str (drop 2 (drop-while #(not= % \>) xs)))
        ns  (str/split ns1 #", ")]
    (if (= ns [""]) [] [x ns])))

(defn get-input []
  (let [file (file-lines "resources/day07.txt")]
   [(map node-of file)  (filter #(not (empty? %)) (map edges file))]))

(def edges (second (get-input)))
(def nodes (first (get-input)))

(defn weight-of [node]
  (->> nodes (filter (fn [[a _]] (= a node))) first second))

(defn neighbors [node]
  (->> edges (filter (fn [[a _]] (= a node))) first second))

(defn total-weight [node]
  (let [n (neighbors node)]
    (if (nil? n)
      (weight-of node)
      (+ (weight-of node)
         (apply + (map total-weight n))))))

(defn find-unique [xs]
  (let [as (map second xs)]
    (first
      (filter (fn [[a b]] (= 1 (count (filter #(= % b) as))))
              xs))))

(defn find-problem [diff node]
  (let [ns (neighbors node)
        ts (map total-weight ns)]
    (if (apply = ts)
      (+ (weight-of node) diff)
      (let [u  (find-unique (map vector ns ts))]
        (find-problem diff (first u))))))

(defn part-1
  "Day 7 part 1 solution"
  []
  (first (filter (fn [n] (not (some #(elem % n) (map second edges))))
                 (map first nodes))))

(defn part-2
  "Day 7 part 2 solution"
  []
  (let [ns (neighbors (part-1))
        z  (map vector ns (map total-weight ns))
        u  (find-unique z)
        n  (first (filter #(not= u %) z))
        d  (- (second n) (second u))]
    (find-problem d (first u))))
