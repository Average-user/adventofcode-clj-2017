(ns advent-of-code-2017.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2017.day01 :as day01]
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
            [advent-of-code-2017.day19 :as day19]
            [advent-of-code-2017.day20 :as day20]
            [advent-of-code-2017.day21 :as day21]
            [advent-of-code-2017.day22 :as day22]
            [advent-of-code-2017.day23 :as day23]
            [advent-of-code-2017.day24 :as day24]
            [advent-of-code-2017.day25 :as day25]))

(deftest day01-part-1
  (is (= (day01/part-1) 1216)))

(deftest day01-part-2
  (is (= (day01/part-2) 1072)))


(deftest day02-part-1
  (is (= (day02/part-1) 58975)))

(deftest day02-part-2
  (is (= (day02/part-2) 308)))


(deftest day03-part-1
  (is (= (day03/part-1) 552)))

(deftest day03-part-2
  (is (= (day03/part-2) 330785)))


(deftest day04-part-1
  (is (= (day04/part-1) 337)))

(deftest day04-part-2
  (is (= (day04/part-2) 231)))


(deftest day05-part-1
  (is (= (day05/part-1) 373160)))

(deftest day05-part-2
  (is (= (day05/part-2) 26395586)))


(deftest day06-part-1
  (is (= (day06/part-1) 12841)))

(deftest day06-part-2
  (is (= (day06/part-2) 8038)))


(deftest day07-part-1
  (is (= (day07/part-1) "cyrupz")))

(deftest day07-part-2
  (is (= (day07/part-2) 193)))


(deftest day08-part-1
  (is (= (day08/part-1) 4066)))

(deftest day08-part-2
  (is (= (day08/part-2) 4829)))


(deftest day09-part-1
  (is (= (day09/part-1) 11089)))

(deftest day09-part-2
  (is (= (day09/part-2) 5288)))


(deftest day10-part-1
  (is (= (day10/part-1) 15990)))

(deftest day10-part-2
  (is (= (day10/part-2) "90adb097dd55dea8305c900372258ac6")))


(deftest day11-part-1
  (is (= (day11/part-1) 818)))

(deftest day11-part-2
  (is (= (day11/part-2) 1596)))


(deftest day12-part-1
  (is (= (day12/part-1) 175)))

(deftest day12-part-2
  (is (= (day12/part-2) 213)))


(deftest day13-part-1
  (is (= (day13/part-1) 1476)))

(deftest day13-part-2
  (is (= (day13/part-2) 3937334)))


(deftest day14-part-1
  (is (= (day14/part-1) 8250)))

(deftest day14-part-2
  (is (= (day14/part-2) 1113)))


(deftest day15-part-1
  (is (= (day15/part-1) 650)))

(deftest day15-part-2
  (is (= (day15/part-2) 336)))


(deftest day16-part-1
  (is (= (day16/part-1) "ociedpjbmfnkhlga")))

(deftest day16-part-2
  (is (= (day16/part-2) "gnflbkojhicpmead")))


(deftest day17-part-1
  (is (= (day17/part-1) 1912)))

(deftest day17-part-2
  (is (= (day17/part-2) 21066990)))


(deftest day18-part-1
  (is (= (day18/part-1) 8600)))

(deftest day18-part-2
  (is (= (day18/part-2) 7239)))


(deftest day19-part-1
  (is (= (day19/part-1) "MKXOIHZNBL")))

(deftest day19-part-2
  (is (= (day19/part-2) 17872)))


(deftest day20-part-1
  (is (= (day20/part-1) 119)))

(deftest day20-part-2
  (is (= (day20/part-2) 471)))


(deftest day21-part-1
  (is (= (day21/part-1) 152)))

(deftest day21-part-2
  (is (= (day21/part-2) 1956174)))


(deftest day22-part-1
  (is (= (day22/part-1) 5538)))

(deftest day22-part-2
  (is (= (day22/part-2) 2511090)))


(deftest day23-part-1
  (is (= (day23/part-1) 5929)))

(deftest day23-part-2
  (is (= (day23/part-2) 907)))


(deftest day24-part-1
  (is (= (day24/part-1) 1868)))

(deftest day24-part-2
  (is (= (day24/part-2) 1841)))


(deftest day25-part-1
  (is (= (day25/part-1) 4225)))
