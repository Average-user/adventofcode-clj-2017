(defproject advent-of-code-2017 "0.1.0-SNAPSHOT"
  :description "Solutions to advent of code 2017"
  :url "https://github.com/Average-user/adventofcode-clj-2017"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.4"]]
  :main ^:skip-aot advent-of-code-2017.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
