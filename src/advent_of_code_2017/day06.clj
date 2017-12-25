(ns advent-of-code-2017.day06
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [string->int]]))

(defn get-input []
  (mapv string->int
        (str/split (slurp "resources/day06.txt") #"\t")))

(defn distribute [xs ixs l]
  (loop [xs xs, ix (map #(mod % l) ixs)]
    (if (empty? ix)
      xs
      (recur (update xs (first ix) inc) (rest ix)))))

(defn relocation [xs n]
  (loop [xs xs, ac (list xs)]
    (let [m   (apply max xs)
          i   (.indexOf xs m)
          ixs (range (inc i) (+ 1 i m))
          xst (assoc xs i 0)
          nxs (distribute xst ixs n)]
      (if (some #(= nxs %) ac)
        ac
        (recur nxs (cons nxs ac))))))
      
(defn first-cycle [xs]
  (relocation xs (count xs)))

(defn part-1
  "Day 6 part 1 solution"
  []
  (count (first-cycle (get-input))))

(defn part-2
  "Day 6 part 2 solution"
  []
  (let [input (get-input)]
    (count (relocation (first (first-cycle input)) (count input)))))

