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
            [advent-of-code-2017.day16 :as day16]))

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
