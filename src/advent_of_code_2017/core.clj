(ns advent-of-code-2017.core
  (:require [advent-of-code-2017.day01 :as day01]
            [advent-of-code-2017.day02 :as day02]
            [advent-of-code-2017.day03 :as day03]
            [advent-of-code-2017.day04 :as day04]
            [advent-of-code-2017.day05 :as day05]
            [advent-of-code-2017.day06 :as day06]
            [advent-of-code-2017.day07 :as day07]
            [advent-of-code-2017.day08 :as day08]
            [advent-of-code-2017.day09 :as day09]
            [advent-of-code-2017.day10 :as day10]
            [advent-of-code-2017.day11 :as day11]
            [advent-of-code-2017.day12 :as day12]
            [advent-of-code-2017.day13 :as day13]
            [advent-of-code-2017.day14 :as day14]
            [advent-of-code-2017.day15 :as day15]
            [advent-of-code-2017.day16 :as day16]
            [advent-of-code-2017.day17 :as day17]
            [advent-of-code-2017.day18 :as day18]
            [advent-of-code-2017.day19 :as day19]))

(defn my-format [x]
  (str x (apply str (take (- 32 (count (str x))) (repeat " "))) " |"))
  

(defn -main []
  (do
    (println "\n  ===============================================")
    (println " | Day | Part | Solution                         |")
    (println " |===============================================|")
    (println (str " |  1  |  A   | " (my-format (day01/part-1))))
    (println (str " |  1  |  B   | " (my-format (day01/part-2))))
    (println (str " |  2  |  A   | " (my-format (day02/part-1))))
    (println (str " |  2  |  B   | " (my-format (day02/part-2))))
    (println (str " |  3  |  A   | " (my-format (day03/part-1))))
    (println (str " |  3  |  B   | " (my-format (day03/part-2))))
    (println (str " |  4  |  A   | " (my-format (day04/part-1))))
    (println (str " |  4  |  B   | " (my-format (day04/part-2))))
    (println (str " |  5  |  A   | " (my-format (day05/part-1))))
    (println (str " |  5  |  B   | " (my-format (day05/part-2))))
    (println (str " |  6  |  A   | " (my-format (day06/part-1))))
    (println (str " |  6  |  B   | " (my-format (day06/part-2))))
    (println (str " |  7  |  A   | " (my-format (day07/part-1))))
    (println (str " |  7  |  B   | " (my-format (day07/part-2))))
    (println (str " |  8  |  A   | " (my-format (day08/part-1))))
    (println (str " |  8  |  B   | " (my-format (day08/part-2))))
    (println (str " |  9  |  A   | " (my-format (day09/part-1))))
    (println (str " |  9  |  B   | " (my-format (day09/part-2))))
    (println (str " | 10  |  A   | " (my-format (day10/part-1))))
    (println (str " | 10  |  B   | " (my-format (day10/part-2))))
    (println (str " | 11  |  A   | " (my-format (day11/part-1))))
    (println (str " | 11  |  B   | " (my-format (day11/part-2))))
    (println (str " | 12  |  A   | " (my-format (day12/part-1))))
    (println (str " | 12  |  B   | " (my-format (day12/part-2))))
    (println (str " | 13  |  A   | " (my-format (day13/part-1))))
    (println (str " | 13  |  B   | " (my-format (day13/part-2))))
    (println (str " | 14  |  A   | " (my-format (day14/part-1))))
    (println (str " | 14  |  B   | " (my-format (day14/part-2))))
    (println (str " | 15  |  A   | " (my-format (day15/part-1))))
    (println (str " | 15  |  B   | " (my-format (day15/part-2))))
    (println (str " | 16  |  A   | " (my-format (day16/part-1))))
    (println (str " | 16  |  B   | " (my-format (day16/part-2))))
    (println (str " | 17  |  A   | " (my-format (day17/part-1))))
    (println (str " | 17  |  B   | " (my-format (day17/part-2))))
    (println (str " | 18  |  A   | " (my-format (day18/part-1))))
    (println (str " | 18  |  B   | " (my-format (day18/part-2))))
    (println (str " | 19  |  A   | " (my-format (day19/part-1))))
    (println (str " | 19  |  B   | " (my-format (day19/part-2))))
    (println "  ===============================================")))
    


