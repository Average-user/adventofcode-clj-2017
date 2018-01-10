(ns advent-of-code-2017.day17
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn get-input []
  (string->int (first (file-lines "resources/day17.txt"))))

(defn insert-at [xs i x]
  (let [[a b] (split-at (inc i) xs)]
    (concat a (cons x b))))

(defn spinlock [[xs n i s]]
  (let [ni (mod (+ 1 i s) (count xs))]
    [(insert-at xs ni n) (inc n) ni s]))

(defn safe-spinlock [skip times]
  (loop [t times, f nil, i 0, n 1]
    (let [ni (rem (+ 1 i skip) n)]
      (cond (zero? t)  f
            (zero? ni) (recur (dec t) n ni (inc n))
            :else      (recur (dec t) f ni (inc n))))))

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
  (-> (get-input) (safe-spinlock 50000000)))  
