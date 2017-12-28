(ns advent-of-code-2017.day20
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int,
                                                elem]]))

(defn line->particule [s]
  (as-> s $ (filter #(not (elem "<>=pva " %)) $)
            (apply str $)
            (str/split $ #",")
            (map string->int $)
            (partition 3 $)
            (mapv vec $)))

(defn get-input []
  (->> "resources/day20.txt" file-lines (map line->particule)))

(defn acc-abs [[_ _ [x y z]]]
  (reduce + (map #(Math/abs %) [x y z])))

(defn new-particule [[ps vs as]]
  (let [nvs (mapv + vs as)]
    [(mapv + ps nvs) nvs as]))

(defn count-times [xs x] (count (filter #(= x %) xs)))

(defn del-collisions [particules]
  (let [ps (map first particules)]
    (map new-particule
         (filter #(> 2 (count-times ps (first %))) particules))))

(defn part-1 []
  "Day 20 part 1 solution"
  []
  (let [accs (map acc-abs (get-input))]
    (.indexOf accs (reduce min accs))))

(defn part-2 []
  (->> (get-input) (iterate del-collisions) (drop 50) first count))
