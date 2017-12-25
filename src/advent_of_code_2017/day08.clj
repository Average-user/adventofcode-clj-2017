(ns advent-of-code-2017.day08
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int]]))

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
        
    [f (map #(vector % 0) v)]))

(defn get-val [var vars]
  (->> vars (drop-while #(not= (first %) var)) first second))

(defn eval-cond [var con n vars]
  (let [v (get-val var vars)
        c (if (= con "!=") "not=" con)]
    (eval (read-string (str "(" c " " v " " n ")")))))

(defn change [vars var op x]
  (let [f (if (= op "inc") + -)]
    (map (fn [[n v]] (if (= n var) [n (f v x)] [n v])) vars)))

(defn run [vars ins]
  (loop [vs vars, is ins, m []]
    (if (empty? is)
      [vs m]
      (let [[v op n cv con cn] (first is)]
        (if (eval-cond cv con cn vs)
          (let [nvs (change vs v op n)]
            (recur nvs (rest is) (conj m (apply max (map second nvs)))))
          (recur vs (rest is) m))))))

(defn part-1 []
  "day 8 part 1 solution"
  []
  (let [input (get-input)]
    (->> (run (second input) (first input))
         first
         (map second)
         (apply max))))

(defn part-2 []
  "day 8 part 1 solution"
  []
  (let [input (get-input)]
    (apply max (second (run (second input) (first input))))))
