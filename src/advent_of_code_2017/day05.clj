(ns advent-of-code-2017.day05
  (:require [advent-of-code-2017.common :refer [file-lines,
                                                string->int]]))

(defn get-input []
  (mapv string->int (file-lines "resources/day05.txt")))

(defn move [xs l p]
  (let [f (if (= p :a) inc #(if (> % 2) (dec %) (inc %)))]
    (loop [xs xs, i 0, c 0]
      (if (or (< i 0) (> i l))
        c
        (recur (update xs i f) (+ i (get xs i)) (inc c))))))

(defn part-1
  "Day 5 part 1 solution"
  []
  (let [input (get-input)]
    (move input (dec (count input)) :a)))

(defn part-2
  "Day 5 part 2 solution"
  []
  (let [input (get-input)]
    (move input (dec (count input)) :b)))
