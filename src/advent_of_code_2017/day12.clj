(ns advent-of-code-2017.day12
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines,
                                                string->int,
                                                elem]]))

(defn get-node [s]
  (let [[node, neighbors] (str/split s #" <-> ")]
    [(string->int node) (mapv string->int (str/split neighbors #", "))]))

(defn get-input []
  (map get-node (file-lines "resources/day12.txt")))

(defn connected-with [n graph]
  (loop [gs graph, g graph, cs [n]]
    (if (empty? gs)
      cs
      (let [[n nb] (first gs)]
        (if (elem cs n)
          (let [ng (filter #(not= (first %) n) g)]
            (recur ng ng (apply conj cs nb)))
          (recur (rest gs) g cs))))))

(defn find-connected [graph]
  (loop [gs graph, ac []]
    (if (empty? gs)
      ac
      (let [cs  (connected-with (ffirst gs) gs)
            ngs (filter #(not (elem cs (first %))) gs)]
        (recur ngs (conj ac cs))))))

(defn part-1
  "Day 12 part 1 solution"
  []
  (->> (get-input) (connected-with 0) distinct count))

(defn part-2
  "Day 12 part 1 solution"
  []
  (->> (get-input) find-connected count))
