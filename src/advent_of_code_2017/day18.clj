(ns advent-of-code-2017.day18
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int,
                                                elem]]))

(def abc ["a" "b" "c" "d" "e" "f" "g" "h" "i" "o" "j" "k" "l" "m"
          "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn line->instruction [s]
  (let [ss (str/split s #" ")]  
    (case (first ss)
      "snd" [:snd (ss 1)]
      "set" [:set (ss 1) (ss 2)]
      "add" [:add (ss 1) (ss 2)]
      "mul" [:mul (ss 1) (ss 2)]
      "mod" [:mod (ss 1) (ss 2)]
      "rcv" [:rcv (ss 1)]
      "jgz" [:jgz (ss 1) (ss 2)])))

(defn get-vars [s]
  (let [ss (str/split s #" ")]
    (if (= 2 (count ss)) [(ss 1)] [(ss 1) (ss 2)])))

(defn get-input []
  (let [input  (file-lines "resources/day18.txt")
        vars   (flatten (map get-vars input))
        vars'  (filter #(elem abc %) vars)
        vars'' (vec (distinct (map #(vector % 0) vars')))]
    [(mapv line->instruction input) vars'']))

(defn get-value [vars var]
  (let [find (first (filter (fn [[v _]] (= v var)) vars))]
    (if find (second find) (string->int var))))

(defn replace-var [vars var v]
  (mapv (fn [[var' v']] (if (= var' var) [var v] [var' v'])) vars))

(defn get-f [ins]
  (case (first ins)
    :add +
    :mul *
    :mod mod))

(defn apply-instruction [ins [end i vars snds]]
  (let [in (nth ins i)]
    (case (first in)
      :snd
      [end (inc i) vars (conj snds (get-value vars (in 1)))]
      :set
      (let [nv (get-value vars (in 2))]
        [end (inc i) (replace-var vars (in 1) nv) snds])
      :rcv
      (let [v (get-value vars (in 1))]
        (if (zero? v) [end i vars snds] [true i vars snds]))
      :jgz
      (let [x (get-value vars (in 1)) y (get-value vars (in 2))]
        (if (> x 0) [end (+ i y) vars snds] [end (inc i) vars snds]))
      (let [x (get-value vars (in 1)) y (get-value vars (in 2)) f (get-f in)]
        [end (inc i) (replace-var vars (in 1) (f x y)) snds]))))

(defn apply-instruction2 [i vars rcvs in]
  (case (first in)
    :snd
    [(inc i) vars (get-value vars (in 1)) rcvs]
    :set
    (let [nv (get-value vars (in 2))]
      [(inc i) (replace-var vars (in 1) nv) nil rcvs])
    :rcv
    (if (empty? rcvs)
      [i vars nil rcvs]
      [(inc i) (replace-var vars (in 1) (first rcvs)) nil (vec (rest rcvs))])
    :jgz
    (let [x (get-value vars (in 1)) y (get-value vars (in 2))]
      (if (> x 0)
        [(+ i y) vars nil rcvs]
        [(inc i) vars nil rcvs]))
    (let [x (get-value vars (in 1)) y (get-value vars (in 2)) f (get-f in)]
      [(inc i) (replace-var vars (in 1) (f x y)) nil rcvs])))

(defn shared-programs [ins vars]
  (loop [ia 0, ib 0, vsa vars, vsb (replace-var vars "p" 1), qa [], qb [], c 0]
    (let [[ia' vsa' sa qa'] (apply-instruction2 ia vsa qa (ins ia))
          [ib' vsb' sb qb'] (apply-instruction2 ib vsb qb (ins ib))
          qa''              (if (nil? sb) qa' (conj qa' sb))
          qb''              (if (nil? sa) qb' (conj qb' sa))]
      (cond (and (= ia ia') (= ib ib')) c
            (not (nil? sb)) (recur ia' ib' vsa' vsb' qa'' qb'' (inc c))
            :else           (recur ia' ib' vsa' vsb' qa'' qb'' c)))))
            

(defn part-1
  "Day 18 part 1solution"
  []
  (let [[instructions vars] (get-input)]
    (last
      (last
        (first (drop-while #(not (first %))
                            (iterate (partial apply-instruction instructions)
                                     [false 0 vars []])))))))

(defn part-2
  "Day 18 part 1solution"
  []
  (let [[instructions vars] (get-input)]
    (shared-programs instructions vars)))
