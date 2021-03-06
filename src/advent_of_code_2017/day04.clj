(ns advent-of-code-2017.day04
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines]]))

(defn get-input []
  (->> "resources/day04.txt" file-lines (map #(str/split % #" "))))

(defn part-1
  "Day 4 part 1 solution"
  []
  (count (filter #(apply distinct? %) (get-input))))

(defn part-2
  "Day 4 part 2 solution"
  []
  (count (filter #(apply distinct? (map sort %)) (get-input))))
