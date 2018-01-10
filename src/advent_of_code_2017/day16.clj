(ns advent-of-code-2017.day16
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn to-instruction [s]
  (cond (= \s (first s))   [:s (string->int s)]
        (= \x (first s))   (let [[a b] (mapv string->int (str/split s #"/"))]
                             [:x a b])
        (= \p (first s))   (let [[a b] (str/split (apply str (rest s)) #"/")]
                             [:p (first a) (first b)])))

(defn get-input []
  (as-> "resources/day16.txt" f
    (file-lines f) (first f) (str/split f #",") (map to-instruction f)))

(defn spin [n xs]
  (let [[a b] (split-at (- (count xs) n) xs)]
    (concat b a)))

(defn exchange [i i' xs]
  (let [a (nth xs i), b (nth xs i')]
    (map #(cond (= %2 i) b (= %2 i') a :else %1) xs (range))))

(defn partner [a b xs]
  (map #(cond (= a %) b (= b %) a :else %) xs))

(defn dance [xs instructions]
  (loop [xs xs, is instructions]
    (if (empty? is)
      xs
      (let [f (first is)]
        (case (first f)
          :s (recur (spin (second f) xs)              (rest is))
          :x (recur (exchange (nth f 1) (nth f 2) xs) (rest is))
          :p (recur (partner (nth f 1) (nth f 2) xs)  (rest is)))))))

(defn find-cycle [xs is]
  (loop [xs xs, ac []]
    (if (some #(= % xs) ac)
      (rest ac)
      (let [nxs (dance xs is)]
        (recur nxs (conj ac xs))))))

(defn after-one-billion [cycle]
  (let [i (rem 1000000000 (count cycle))]
    (nth cycle (dec i))))

(defn part-1
  "Day 16 part 1 solution"
  []
  (->> (get-input) (dance "abcdefghijklmnop") (apply str)))

(defn part-2
  "Day 16 part 2 solution"
  []
  (->> (get-input)
    (find-cycle "abcdefghijklmnop") (map #(apply str %)) after-one-billion))
