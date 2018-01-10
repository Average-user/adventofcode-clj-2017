(ns advent-of-code-2017.day01
  (:require [advent-of-code-2017.common :refer [digits, file-lines]]))

(defn get-input []
  (-> "resources/day01.txt" file-lines first digits vec))

(defn part-1
  "Day 1 part 1 solution"
  []
  (let [i (get-input)
        x (reduce + (map #(if (= %1 %2) %1 0) i (rest i)))]
    (if-not (= (first i) (last i)) x (+ (first i) x))))

(defn part-2
  "Day 1 part 2 solution"
  []
  (let [input (get-input)
        c     (cycle input)
        l     (quot (count input) 2)]
    (reduce + (map input (filter #(= (nth c %) (nth c (+ % l)))
                                 (range (* 2 l)))))))
