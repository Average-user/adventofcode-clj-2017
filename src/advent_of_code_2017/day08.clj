(ns advent-of-code-2017.day08
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn action-condition [s]
  (let [[a c] (str/split s #"if ")
        var   (apply str (take-while #(not= \space %) a))
        op    (second (str/split a #" "))
        n     (string->int (last (str/split a #" ")))
        cvar  (apply str (take-while #(not= \space %) c))
        con   (second (str/split c #" "))
        cn    (string->int (last (str/split c #" ")))]
    [var op n cvar con cn]))

(defn get-input []
  (let [f (->> "resources/day08.txt" file-lines (map action-condition))
        v (distinct (flatten (map (fn [[a _ _ b _ _]] [a b]) f)))]
    [f (into {} (map #(vector % 0) v))]))

(defn eval-cond [var con n vars]
  (let [v (get vars var)
        c (if (= con "!=") "not=" con)]
    (eval (read-string (str "(" c " " v " " n ")")))))

(defn change [vars var op x]
  (let [f (if (= op "inc") + -)]
    (update vars var #(f % x))))

(defn run [vars ins]
  (loop [vs vars, is ins, m (mapv val vs)]
    (if (empty? is)
      [vs m]
      (let [[v op n cv con cn] (first is)]
        (if (eval-cond cv con cn vs)
          (let [nvs (change vs v op n)]
            (recur nvs (rest is) (conj m (get nvs v))))
          (recur vs (rest is) m))))))

(defn part-1 []
  "day 8 part 1 solution"
  []
  (let [input (get-input)]
    (->> (run (second input) (first input))
         (first)
         (map second)
         (apply max))))

(defn part-2 []
  "day 8 part 1 solution"
  []
  (let [input (get-input)]
    (apply max (second (run (second input) (first input))))))
