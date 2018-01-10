(ns advent-of-code-2017.day02
  (:require [clojure.math.combinatorics :as combo]
            [clojure.string :as str]
            [advent-of-code-2017.common :refer [string->int,
                                                file-lines]]))

(defn get-input []
  (map #(str/split % #"\t") (file-lines "resources/day02.txt")))

(defn diff-min-max [xs]
  (- (reduce max xs) (reduce min xs)))

(defn find-2 [xs]
  (let [a (combo/combinations xs 2)
        b (map #(vec (reverse %)) a)
        c (vec (concat a b))]
    (first (filter integer? (map (fn [[x y]] (/ x y)) c)))))

(defn part-1
  "Day 2 part 1 solution"
  []
  (reduce + (map #(diff-min-max (map string->int %)) (get-input))))

(defn part-2
  "Day 2 part 2 solution"
  []
  (reduce + (map #(find-2 (map string->int %)) (get-input))))
