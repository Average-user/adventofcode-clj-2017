(ns advent-of-code-2017.day09
  (:require [advent-of-code-2017.common :refer [file-lines]]))

(defn get-input []
  (seq (char-array (first (file-lines "resources/day09.txt")))))

(defn ignore [xs]
  (loop [xs xs, ac []]
    (if (= 1 (count xs))
      (conj ac (first xs))
      (let [f (first xs), s (second xs), r (rest xs)]
        (if (= f \!)
          (recur (rest r) ac)
          (recur r        (conj ac f)))))))

(defn erase-garbage [xs]
  (loop [xs xs, b false, ac [], n 0]
    (cond (empty? xs)                     [ac n]
          (and (= (first xs) \<) (not b)) (recur (rest xs) true  ac n)
          (and (= (first xs) \>) b)       (recur (rest xs) false ac n)
          b                               (recur (rest xs) true  ac (inc n))
          :else                           (recur (rest xs) false (conj ac (first xs)) n))))

(defn clean [xs] (filter #(or (= % \{) (= % \})) xs))

(defn remove-first [xs]
  (loop [xs xs, ac []]
      (if (and (= (first xs) \{) (= (second xs) \}))
        (concat ac (drop 2 xs))
        (recur (rest xs) (conj ac (first xs))))))

(defn count-first [xs]
  (count (take-while #(= % \{) xs)))

(defn groups-of [xs]
  (loop [xs xs, c 0]
    (if (empty? xs)
      c
      (recur (remove-first xs) (+ c (count-first xs))))))

(defn part-1
  "Day 9 part 1 solution"
  []
  (->> (get-input) ignore erase-garbage first clean groups-of))

(defn part-2
  "Day 9 part 2 solution"
  []
  (->> (get-input) ignore erase-garbage second))
