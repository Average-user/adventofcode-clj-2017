(ns advent-of-code-2017.day22
  (:require [advent-of-code-2017.common :refer [file-lines]]))

(defn get-coors [xs]
  (letfn [(infected? [coor] (= \# (get-in xs coor)))
          (c-product [r]    (for [x r, y r] [x y]))]
    (->> xs
      ((comp c-product range count))
      (keep #(when (infected? %) [% :infected]))
      (into {}))))

(defn get-input []
  (let [input (file-lines "resources/day22.txt")
        xs    (mapv #(vec (char-array %)) input)]
    [(count xs) (get-coors xs)]))

(defn move [cdir mdir]
  (case [cdir mdir]
    [:north :right] :east
    [:north :left]  :west
    [:south :right] :west
    [:south :left]  :east
    [:west  :right] :north
    [:west  :left]  :south
    [:east  :right] :south
    [:east  :left]  :north))

(defn forward [dir [x y]]
  (case dir
    :north [(dec x) y]
    :south [(inc x) y]
    :west  [x (dec y)]
    :east  [x (inc y)]))

(defn one-virus-step [[coors [x y] dir c]]
  (if (= :infected (get coors [x y]))

    (let [ndir (move dir :right)]
      [(dissoc coors [x y]) (forward ndir [x y]) ndir c])

    (let [ndir (move dir :left)]
      [(assoc coors [x y] :infected) (forward ndir [x y]) ndir (inc c)])))

(defn reversed [dir]
  (case dir
    :north :south
    :south :north
    :west  :east
    :east  :west))

(defn next-state [state]
  (case state
    :clean    :weakened
    :weakened :infected
    :infected :flagged
    :flagged  :clean))

(defn next-dir [state dir]
  (case state
    :clean    (move dir :left)
    :infected (move dir :right)
    :flagged  (reversed dir)
    :weakened dir))

(defn die-you-all [coors [x y] times]
  (loop [coors coors, [x y] [x y], dir :north, c 0, t times]
    (if (zero? t)
      c
      (let [state  (get coors [x y] :clean)
            ncoors (assoc coors [x y] (next-state state))
            ndir   (next-dir state dir)
            nc     (if-not (= :weakened state) c (inc c))]
        (recur ncoors (forward ndir [x y]) ndir nc (dec t))))))          

(defn part-1
  "Day 22 part 1 solution"
  []
  (let [[l coors] (get-input)
        c         (quot l 2)]
    (peek (nth (iterate one-virus-step [coors [c c] :north 0]) 10000))))

(defn part-2
  "Day 22 part 2 solution"
  []
  (let [[l coors] (get-input)
        c         (quot l 2)]
    (die-you-all coors [c c] 10000000)))
