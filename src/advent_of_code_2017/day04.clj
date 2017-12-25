(ns advent-of-code-2017.day04
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines]]))

(defn get-input []
  (map #(str/split % #" ")
       (file-lines "resources/day04.txt")))

(defn part-1
  "Day 4 part 1 solution"
  []
  (count (filter #(apply distinct? %) (get-input))))

(defn part-2
  "Day 4 part 2 solution"
  []
  (count (filter #(apply distinct? (map sort %)) (get-input))))
