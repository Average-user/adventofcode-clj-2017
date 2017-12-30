(ns advent-of-code-2017.day25
  (:require [clojure.string :as str]
            [advent-of-code-2017.common :refer [file-lines, string->int]]))

(defn description->rule [c-state des]
  (let [c-value     (-> des (nth 0) string->int)
        n-value     (-> des (nth 1) string->int)
        n-state     (-> des (nth 3) reverse rest first str)
        instruction (reverse (take-while #(not= % \space)
                                         (rest (reverse (nth des 2)))))]
    {:c-state     c-state
     :c-value     c-value
     :n-value     n-value
     :instruction (if (= \r (first instruction))
                    "->" "<-")
     :n-state     n-state}))

(defn state-rules [des]
  (let [state (-> des first reverse second str)]
    (->> des rest (partition 4) (map #(description->rule state %)))))

(defn get-rules [lines]
  (let [rules-des (->> lines (filter #(not= "" %)) (partition 9))]
    (mapcat state-rules rules-des))) ;(mapv des->rule rules-des)))

(defn get-input []
  (let [input         (->> "resources/day25.txt" file-lines)
        initial-state (->> input first reverse second str)
        steps         (->> input second string->int)
        rules         (->> input (drop 2) get-rules)]
    [initial-state rules 0 steps]))

(defn go-> [[l c r]]
  (let [[nc nl] ((juxt first rest) l)]
    [nl nc (cons c r)]))

(defn go<- [[l c r]]
  (let [[nc nr] ((juxt first rest) r)]
    [(cons c l) nc nr]))

(defn find-rule [rules state char]
  (first (filter #(let [s (% :c-state), c (% :c-value)]
                    (and (= state s) (= char c)))
                 rules)))

(defn one-step [rules blank [[l c r] state]]
  (let [l' (if (empty? l) (list blank) l)
        r' (if (empty? r) (list blank) r)
        rule (find-rule rules state c)
        nc   (rule :n-value)]
    (case (rule :instruction)
      "->" [(go-> [l' nc r']) (rule :n-state)]
      "<-" [(go<- [l' nc r']) (rule :n-state)])))

(defn part-1
  "Day 25 part 1 solution"
  []
  (let [[i-state rules b steps] (get-input)
        tapes (iterate (partial one-step rules b)
                       [[(list b) b (list b)] i-state])
        [l c r] (first (nth tapes steps))]
    (+ c (reduce + l) (reduce + r))))
  
