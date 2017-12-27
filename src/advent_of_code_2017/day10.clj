(ns advent-of-code-2017.day10
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int,
                                                elem]]))

(defn get-input []
  (as-> "resources/day10.txt"
      x (file-lines x) (first x) (str/split x #",") (mapv string->int x)))

(defn get-input2 []
  (->> "resources/day10.txt" file-lines first (map byte)))

(defn reverse-section
  [nums i l]
  (let [r (map #(rem % 256) (range i (+ i l)))
        m (zipmap r (reverse r))]
    (mapv (fn [i' v] (get nums (get m i' i'))) (range) nums)))

(defn run [xs ls]
  (reduce (fn [[nums i s] l] [(reverse-section nums i l) (+ i l s) (inc s)])
          [xs 0 0] ls))

(defn get-input2 []
  (->> "resources/day10.txt" file-lines first (map byte)))

(defn to-knot-hash [x]
  (->> (concat (map byte x) '(17 31 73 47 23))
       repeat
       (take 64)
       flatten
       (run (vec (range 256)))
       first
       (partition 16) 
       (map #(apply bit-xor %))
       (map #(format "%02x" %))
       (apply str)))

(defn part-1
  "Day 10 part 1 solution"
  []
  (as-> (get-input) x (run (vec (range 256)) x) (first x) (* (first x) (second x))))

(defn part-2
  "Day 10 part 2 solution"
  []
  (->> (get-input2) to-knot-hash))

                                
