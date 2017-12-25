(ns advent-of-code-2017.day01
  (:require [advent-of-code-2017.common :refer [digits]]))

(defn part-1
  "Day 1 part 1 solution"
  []
  (let [input (digits (butlast (slurp "resources/day01.txt")))
        x     (apply + (map #(if (= %1 %2) %1 0) input (rest input)))]
    (if (not= (first input) (last input))
      x
      (+ (first input) x))))

(defn part-2
  "Day 1 part 2 solution"
  []
  (let [input (digits (butlast (slurp "resources/day01.txt")))
        c     (cycle input)
        l     (/ (count input) 2)]
    (apply + (map #(nth input %)
                  (filter #(= (nth c %) (nth c (+ % l)))
                          (range (* 2 l)))))))
