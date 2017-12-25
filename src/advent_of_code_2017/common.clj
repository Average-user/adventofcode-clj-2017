(ns advent-of-code-2017.common)

(defn elem [xs x] (some #(= % x) xs))

(defn digits [n]
  (->> n (map (comp read-string str))))

(defn string->int [s]
  (let [n (Integer. (re-find  #"\d+" s ))]
    (if (= \- (first s))
      (- n)
      n)))
  
(defn file-lines [path]
  (clojure.string/split (slurp path) #"\n"))
