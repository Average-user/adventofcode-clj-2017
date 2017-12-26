(ns advent-of-code-2017.day17
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int]]))

(defn get-input []
  (string->int (first (file-lines "resources/day17.txt"))))

(defn insert-at [xs i x]
  (let [[a b] (split-at (inc i) xs)]
    (concat a (cons x b))))

(defn spinlock [[xs n i s]]
  (let [ni (mod (+ 1 i s) (count xs))]
    [(insert-at xs ni n) (inc n) ni s]))

(defn safe-spinlock [[f i n s]]
  (let [ni (rem (+ 1 i s) n)]
    (if (zero? ni)
      [n ni (inc n) s]
      [f ni (inc n) s])))

(defn part-1
  "Day 17 part 1 solution"
  []
  (as-> (get-input) $
    (iterate spinlock ['(0) 1 0 $])
    (ffirst (drop 2017 $))
    (drop-while #(not= 2017 %) $)
    (second $)))

(defn part-2
  "Day 17 part 2 solution"
  []
  (as-> (get-input) $ (iterate safe-spinlock [nil 0 1 $]) (drop 50000000 $) (ffirst $)))
