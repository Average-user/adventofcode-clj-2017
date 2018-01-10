(ns advent-of-code-2017.day05
  (:require [advent-of-code-2017.common :refer [file-lines,
                                                string->int]]))

(defn get-input []
  (mapv string->int (file-lines "resources/day05.txt")))

(defn move [xs f]
  (loop [xs xs, i 0, c 0]
    (let [ni (get xs i)]
      (if-not ni
        c
        (recur (update xs i f) (+ i ni) (inc c))))))

(defn part-1
  "Day 5 part 1 solution"
  []
  (move (get-input) inc))

(defn part-2
  "Day 5 part 2 solution"
  []
  (move (get-input) #(if (> % 2) (dec %) (inc %))))
