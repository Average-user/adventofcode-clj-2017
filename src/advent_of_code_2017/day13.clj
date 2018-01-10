(ns advent-of-code-2017.day13
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn get-input []
  (->> "resources/day13.txt"
    file-lines (map #(str/split % #": ")) (map #(mapv string->int %))))
         
(defn caught [delay [depth range]]
  (zero? (rem (+ delay depth) (* 2 (dec range)))))

(defn part-1
  "Day 13 part 1 solution"
  []
  (->> (get-input)
    (filter (partial caught 0)) (map #(reduce * %)) (reduce +)))

(defn part-2
  "Day 13 part 1 solution"
  []
  (let [input (get-input)]
    (first (drop-while #(some (partial caught %) input) (range)))))
