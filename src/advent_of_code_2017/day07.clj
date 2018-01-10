(ns advent-of-code-2017.day07
  (:require [clojure.string             :as    str]
            [advent-of-code-2017.common :refer [file-lines, string->int,]]))

(defn parse-line [l]
  (let [x        (str/split l #" -> ")
        [name n] (str/split (first x) #" ")
        ngs      (if-not (second x) []
                         (str/split (second x) #", "))]
    [name [(string->int n) ngs]]))

(defn get-input []
  (->> "resources/day07.txt" file-lines (map parse-line)))

(defn find-root [xs]
  (let [names       (map first xs)
        connections (set (mapcat (comp second second) xs))]
    (first (keep #(when (not (first %)) (second %))
                 (map (fn [x] [(contains? connections x) x]) names)))))

(defn sums [xs x]
  (let [[n subs] (get xs x)]
    (if (empty? subs)
      n
      (+ n (reduce + (map (partial sums xs) subs))))))

(defn is-unique? [xs x]
  (= 1 (count (filter #(= x %) xs))))

(defn sub-sums [gf xs]
  (map (partial sums gf) xs))

(defn find-problem [gf x n]
  (loop [x x]
    (let [xs      (second (get gf x))
          ss      (sub-sums gf xs)
          options (filter #(is-unique? ss (second %))
                          (map vector xs ss))]
      (if (empty? options)
        (+ n (first (get gf x)))
        (recur (ffirst options))))))

(defn part-1
  "Day 7 part 1 solution"
  []
  (-> (get-input) find-root))

(defn part-2
  "Day 7 part 2 solution"
  []
  (let [input  (get-input)
        hinput (apply hash-map (apply concat input))
        root   (find-root input)
        ss     (sub-sums hinput (second (get hinput root)))
        unique (first (filter #(is-unique? ss %) ss))
        diff   (- (first (filter #(not= % unique) ss)) unique)]
    (find-problem hinput root diff)))
