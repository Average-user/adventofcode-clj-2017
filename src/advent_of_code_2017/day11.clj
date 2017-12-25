(ns advent-of-code-2017.day11
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines]]))

(defn get-input []
  (str/split (first (file-lines "resources/day11.txt")) #","))

(defn new-coor [dir [x y z]]
  (case dir
    "n"  [x (inc y) (dec z)]
    "s"  [x (dec y) (inc z)]
    "ne" [(inc x) y (dec z)]
    "sw" [(dec x) y (inc z)]
    "nw" [(dec x) (inc y) z]
    "se" [(inc x) (dec y) z]))

(defn new-max [coor m]
  (apply max [m (apply + (map #(Math/abs %) coor))]))

(defn move [is]
  (loop [coor [0 0 0], is is, m 0]
    (if (empty? is)
      [coor m]
      (let [n-coor (new-coor (first is) coor)]
        (recur n-coor (rest is) (new-max n-coor m))))))

(defn part-1
  "Day 11 part 1 solution"
  []
  (->> (get-input) move first (map #(Math/abs %)) (apply +) (* 1/2) int))

(defn part-2
  "Day 11 part 1 solution"
  []
  (-> (get-input) move second (quot 2)))
