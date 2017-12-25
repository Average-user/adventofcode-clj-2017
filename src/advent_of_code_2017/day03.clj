(ns advent-of-code-2017.day03
  (:require [advent-of-code-2017.common :refer [string->int]]))

(defn printm [x]
  (let [nx (map #(map (fn [y] (format "%2d" y)) %) x)]
    (map println nx)))

(defn get-input []
  (string->int (slurp "resources/day03.txt")))

(defn options [[x y] dir]
  (case dir
    :r [[(dec x) y] [x (inc y)] :u]
    :l [[(inc x) y] [x (dec y)] :d]
    :u [[x (dec y)] [(dec x) y] :l]
    :d [[x (inc y)] [(inc x) y] :r]))

(defn ring-of [x]
  (let [r (/ (inc (Math/sqrt x)) 2)]
    (if (== (int r) r) (int r) (inc (int r)))))

(defn create-initial [n]
  (let [r     (dec (* 2 (ring-of n)))
        lines (vec (take r (repeat 0)))
        c     (int (/ r 2))]
    [(vec (take r (repeat lines))) [c c]]))

(defn move [n]
  (let [[ixs coor] (create-initial n)]
    (loop [xs ixs, [x y] coor, ns (range 1 n), dir :r]
      (if (empty? ns)
        [xs [x y]]
        (let [nxs               (assoc-in xs [x y] (first ns))
              [[h i] [j k] ndir] (options [x y] dir)]
          (if (= 0 (get-in nxs [h i]))
            (recur nxs [h i] (rest ns) ndir)
            (recur nxs [j k] (rest ns) dir)))))))

(defn enlarge [xs]
  (let [c   (vec (take (+ 2 (count xs)) (repeat 0)))
        nxs (mapv #(into [0] (conj % 0)) xs)]
    (into [c] (conj nxs c))))

(defn new-grid [xs [x y]]
  (let [l (dec (count xs))]
    (if-not (or (< x 0) (< y 0) (> x l) (> y l))
      [xs [x y]]
      [(enlarge xs) [(inc x) (inc y)]])))

(defn neighbors-sum [xs [x y]]
  (apply + (keep (fn [[a b]] (get-in xs [(+ x a) (+ y b)]))
                 [[0 1] [1 0] [-1 0] [0 -1] [1 1] [1 -1] [-1 1] [-1 -1]])))

(defn move2 [n]
  (loop [xs [[0 0 0] [0 1 0] [0 0 0]], [x y] [1 2], dir :r]
    (let [[xs1 [a b]]        (new-grid xs [x y])
          new-v              (neighbors-sum xs1 [a b])
          nxs                (assoc-in xs1 [a b] new-v)
          [[h i] [j k] ndir] (options [a b] dir)]
      (if (> new-v n)
        new-v
        (if (= 0 (get-in nxs [h i]))
          (recur nxs [h i] ndir)
          (recur nxs [j k] dir))))))

(defn part-1
  "Day 3 part 1 solution"
  []
  (let [input      (get-input)
        [xs [a b]] (move input)
        c          (int (/ (count xs) 2))]
    (+ (Math/abs (- a c)) (Math/abs (- b c)))))

(defn part-2
  "Day 3 part 2 solution"
  []
  (move2 (get-input)))
