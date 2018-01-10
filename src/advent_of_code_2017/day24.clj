(ns advent-of-code-2017.day24
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn line->component [l]
  (mapv string->int (str/split l #"/")))

(defn find-starts [cs]
  (filter (fn [[a b]] (or (zero? a) (zero? b))) cs))

(defn get-input []
  (let [components (map line->component
                        (file-lines "resources/day24.txt"))]
   [(set components) (find-starts components)]))

(defn connects [[a b] [c d]]
  (cond (= b c) [c d]
        (= b d) [d c]
        :else   nil))

(defn rc [[a b]] [b a])

(defn build-tree [c cs]
  (let [m (keep #(connects c %) cs)]
    (if (empty? m)
      (reduce + c)
      (+ (reduce + c)
         (reduce max (map #(build-tree % (reduce disj cs [% (rc %)]))
                          m))))))

(defn build-tree2 [c cs]
  (let [m (keep #(connects c %) cs)]
    (if (empty? m)
      [1 (reduce + c)]
      ((partial mapv +)
       [1 (reduce + c)]
       (last (sort (map #(build-tree2 % (reduce disj cs [% (rc %)]))
                        m)))))))

(defn part-1
  "Day 24 part 1 solution"
  []
  (let [[cs sts] (get-input)]
    (reduce max (pmap #(build-tree % (reduce disj cs [% (rc %)]))
                      (map (comp vec sort) sts)))))

(defn part-2
  "Day 24 part 2 solution"
  []
  (let [[cs sts] (get-input)]
    ((comp second last sort)
     (pmap #(build-tree2 % (reduce disj cs [% (rc %)]))
           (map (comp vec sort) sts)))))
