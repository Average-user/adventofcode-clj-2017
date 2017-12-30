(ns advent-of-code-2017.day14
  (:require [clojure.string :as str]
            [advent-of-code-2017.day10 :refer [to-knot-hash]]
            [advent-of-code-2017.day12 :refer [find-connected]]
            [advent-of-code-2017.common :refer [file-lines]]))

(defn get-input []
  (->> "resources/day14.txt" file-lines first))


(defn hexdig->bin [dig]
  (case dig
    \0 "0000"
    \1 "0001"
    \2 "0010"
    \3 "0011"
    \4 "0100"
    \5 "0101"
    \6 "0110"
    \7 "0111"
    \8 "1000"
    \9 "1001"
    \a "1010"
    \b "1011"
    \c "1100"
    \d "1101"
    \e "1110"
    \f "1111"))

(defn build-grid [input]
  (as-> input x
    (map #(str x "-" %) (range 128))
    (pmap to-knot-hash x)
    (map #(mapv hexdig->bin %) x)
    (map #(apply str %) x)
    (mapv (fn [s] (mapv #(if (= % \1) 1 0) s)) x)))

(defn neighbors-1 [xs [x y]]
  (let [ns (mapv (fn [[a b]] [(+ x a) (+ y b)])
                 [[0 1] [1 0] [0 -1] [-1 0]])]
    (filter #(= 1 (get-in xs %)) ns)))

(defn all-coors [n]
  (as-> (range n) $ (for [x $, y $] [x y])))

(defn grid->graph [xs]
  (let [coors (->> xs count all-coors (filter #(= 1 (get-in xs %))))]
    (map #(vector % (neighbors-1 xs %)) coors)))

(defn part-1
  "Day 14 part 1 solution"
  []
  (->> (get-input) build-grid (map #(reduce + %)) (reduce +)))

(defn part-2
  "Day 14 part 1 solution"
  []
  (->> (get-input) build-grid grid->graph find-connected count))

