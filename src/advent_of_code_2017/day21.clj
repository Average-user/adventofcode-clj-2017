(ns advent-of-code-2017.day21
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                elem]]))

(defn transpose [m] (apply map list m))

(defn change [xs]
  (map #(map (fn [x] (if (= x \.) 0 1)) %) xs))

(defn rotate [m] (reverse (transpose m)))

(defn all-ways [m]
  (let [rs (take 4 (iterate rotate m))]
    (distinct (mapcat #(list % (reverse %)) rs))))

(defn line->rule [s]
  (let [[l r] (str/split s #" => ")
        a  (change (str/split l #"/"))
        b  (change (str/split r #"/"))]
    (map (fn [x] [x b]) (all-ways a))))

(defn get-input []
  (->> "resources/day21.txt" file-lines (map line->rule) (reduce concat)))

(def init '((0 1 0) (0 0 1) (1 1 1)))

(defn match [rules m]
  (second (first (drop-while #(not= (first %) m) rules))))

(defn next-m [rules xs n]
  (let [ps  (map #(partition n %) xs)
        pps (partition n ps)
        ds  (map transpose pps)
        cs  (map #(map (partial match rules) %) ds)]
    (mapcat #(apply  map concat %) cs)))

(defn change-matrix [rules m]
  (if (zero? (rem (count m) 2))
    (next-m rules m 2)
    (next-m rules m 3)))

(defn increase-matrix [n m rules]
  (loop [c 0, m m]
    (if (= c n)
      m
      (recur (inc c) (change-matrix rules m)))))

(defn count-ones [xs]
  (reduce + (map #(reduce + %) xs)))

(defn part-1
  "Day 21 part 1 solution"
  []
  (let [input (get-input)]
    (count-ones (increase-matrix 5 init input))))

(defn part-2
  "Day 22 part 1 solution"
  []
  (let [input (get-input)]
    (count-ones (increase-matrix 18 init input))))
