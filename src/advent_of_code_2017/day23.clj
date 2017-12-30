(ns advent-of-code-2017.day23
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn line->instruction [s]
  (let [ss (str/split s #" ")]  
    (case (first ss)
      "set" [:set (ss 1) (ss 2)]
      "sub" [:sub (ss 1) (ss 2)]
      "mul" [:mul (ss 1) (ss 2)]
      "jnz" [:jnz (ss 1) (ss 2)])))

(defn get-input []
  (let [input  (file-lines "resources/day23.txt")
        inst   (mapv line->instruction input)
        vars   (apply hash-map (mapcat list (map str "abcdefgh")
                                            (repeat 0)))]
    [inst vars (string->int (peek (first inst)))]))

(defn get-value [vars var]
  (let [in (get vars var)] (if-not in (string->int var) in)))

(defn one-instruction [ins [i vars c]]
  (let [in (get ins i)]
    (if (nil? in)
      nil
      (let [x (get-value vars (in 1)), y (get-value vars (in 2))]
        (case (first in)
          :set [(inc i) (assoc vars (in 1) y) c]
          :mul [(inc i) (assoc vars (in 1) (* x y)) (inc c)]
          :sub [(inc i) (assoc vars (in 1) (- x y)) c]
          :jnz (if (zero? x)  [(inc i) vars c] [(+ i y) vars c]))))))

(defn prime? [x]
  (not (or (= 1 x) (even? x)
           (some #(zero? (mod x %))
                 (range 3 (inc (int (Math/sqrt x))))))))     

(defn part-1
  "Day 23 part 1 solution"
  []
  (let [[instructions vars _] (get-input)]
    ((comp peek last (partial take-while identity))
     (iterate (partial one-instruction instructions) [0 vars 0]))))

(defn part-2
  "Day 23 part 2 solution"
  []
  (let [b  (peek (get-input))
        z  (+ (* b 100) 100000)
        t  (+ z 17000)
        ns (take-while #(<= % t) (iterate #(+ % 17) z))]
    (count (filter #(not (prime? %)) ns))))
