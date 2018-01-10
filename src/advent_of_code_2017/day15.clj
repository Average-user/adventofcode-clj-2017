(ns advent-of-code-2017.day15
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn get-input []
  (->> "resources/day15.txt" file-lines (mapv string->int)))

(defn new-a [a] (rem (* a 16807) 2147483647))
(defn new-b [b] (rem (* b 48271) 2147483647))

(defn next-pair [[a b]] [(new-a a) (new-b b)])

(defn eq-start [n [a b]]
  (or (zero? n)
      (and (= (rem a 2) (rem b 2))
           (eq-start (dec n) [(quot a 2) (quot b 2)]))))

(defn part-1
  "day 15 part 1 solution"
  []
  (->> (get-input)
    (next-pair)
    (iterate next-pair)
    (take 40000000)
    (filter #(eq-start 16 %))
    (count)))

(defn part-2
  "day 15 part 1 solution"
  []
  (let [[a b] (get-input)
        as (filter #(zero? (mod % 4)) (iterate new-a (new-a a)))
        bs (filter #(zero? (mod % 8)) (iterate new-b (new-b b)))]
    (->> (map vector as bs) (take 5000000) (filter #(eq-start 16 %)) count)))
