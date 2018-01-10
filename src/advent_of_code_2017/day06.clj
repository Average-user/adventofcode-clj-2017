(ns advent-of-code-2017.day06
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn get-input []
  (as-> "resources/day06.txt" $
    (file-lines $) (first $) (str/split $ #"\t") (mapv string->int $)))

(defn distribute [xs ixs l]
  (reduce #(update %1 (mod %2 l) inc) xs ixs))

(defn relocation [xs n]
  (loop [xs xs, ac (set (list xs))]
    (let [m   (apply max xs)
          i   (.indexOf xs m)
          ixs (range (inc i) (+ 1 i m))
          xst (assoc xs i 0)
          nxs (distribute xst ixs n)]
      (if (contains? ac nxs)
        [ac xs]
        (recur nxs (conj ac nxs))))))

(defn first-cycle [xs]
  (relocation xs (count xs)))

(defn part-1
  "Day 6 part 1 solution"
  []
  (count (first (first-cycle (get-input)))))

(defn part-2
  "Day 6 part 2 solution"
  []
  (let [input (get-input)]
    (count (first (relocation (second (first-cycle input)) (count input))))))

