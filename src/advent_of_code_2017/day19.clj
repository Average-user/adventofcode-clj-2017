(ns advent-of-code-2017.day19
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines]]))

(def abc (set (vec (char-array "ABCDEFGHIJKLMNOPQRSTUVWXYZ"))))

(defn get-input []
  (->> "resources/day19.txt" file-lines (mapv #(vec (char-array %)))))

(defn find-entry [xs]
  (-> xs first (.indexOf \|) (vector 0) reverse vec))

(defn options [dir]
  (case dir
    :up    [[-1 0 :up]    [0  1 :right] [0 -1 :left]]
    :down  [[1  0 :down]  [0  1 :right] [0 -1 :left]]
    :right [[0  1 :right] [1  0 :down]  [-1 0 :up]]
    :left  [[0 -1 :left]  [1  0 :down]  [-1 0 :up]]))

(defn chose [xs dir [x y]]
  (let [op (mapv (fn [[a b d]] [(+ x a) (+ y b) d])
                 (options dir))
        in (mapv (fn [[a b d]] [[a b] (get-in xs [a b]) d]) op)]     
    (first (filter (fn [[_ i _]] (not (or (nil? i) (= \space i))))
                   in))))

(defn walk [xs]
  (loop [coor (find-entry xs), dir :down, ls [], c 1]
    (let [[ncoor e ndir] (chose xs dir coor)]
      (cond (nil? ncoor)      [(reduce str ls) c]
            (contains? abc e) (recur ncoor ndir (conj ls e) (inc c))
            :else             (recur ncoor ndir ls          (inc c))))))

(defn part-1
  "Day 19 part 1 solution"
  [] (->> (get-input) walk first))

(defn part-2
  "Day 19 part 2 solution"
  [] (->> (get-input) walk second))
