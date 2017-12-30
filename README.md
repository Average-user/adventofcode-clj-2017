# Advent Of Code 2017 (Clojure)

An attempt to re-catch myself with Clojure, and hopefully stick with it,
if you find something that you think can be improved you are more than
welcomed to make a contribution.

## Project structure

Input files will be stored at ```resources/dayXX.txt```
and solutions in ```src/advent_of_code_2017/dayXX.clj```.
The file ```src/advent_of_code_2017/common.clj``` will have
some code that is used by multiple solutions, and will also
exist a test file in ```test/advent_of_code_2017/core_test.clj```

## Usage

Inside the project folder, the command:

``` text
lein run
```

will show the solution for every puzzle so far implemented:

``` text
$ lein run

  ===============================================
 | Day | Part | Solution                         |
 |===============================================|
 |  1  |  A   | 1216                             |
 |  1  |  B   | 1072                             |
 |  2  |  A   | 58975                            |
 |  2  |  B   | 308                              |
 |  3  |  A   | 552                              |
 |  3  |  B   | 330785                           |
 |  4  |  A   | 337                              |
 |  4  |  B   | 231                              |
 |  5  |  A   | 373160                           |
 |  5  |  B   | 26395586                         |
 |  6  |  A   | 12841                            |
 |  6  |  B   | 8038                             |
 |  7  |  A   | cyrupz                           |
 |  7  |  B   | 193                              |
 |  8  |  A   | 4066                             |
 |  8  |  B   | 4829                             |
 |  9  |  A   | 11089                            |
 |  9  |  B   | 5288                             |
 | 10  |  A   | 15990                            |
 | 10  |  B   | 90adb097dd55dea8305c900372258ac6 |
 | 11  |  A   | 818                              |
 | 11  |  B   | 1596                             |
 | 12  |  A   | 175                              |
 | 12  |  B   | 213                              |
 | 13  |  A   | 1476                             |
 | 13  |  B   | 3937334                          |
 | 14  |  A   | 8250                             |
 | 14  |  B   | 1113                             |
 | 15  |  A   | 650                              |
 | 15  |  B   | 336                              |
 | 16  |  A   | ociedpjbmfnkhlga                 |
 | 16  |  B   | gnflbkojhicpmead                 |
 | 17  |  A   | 1912                             |
 | 17  |  B   | 21066990                         |
 | 18  |  A   | 8600                             |
 | 18  |  B   | 7239                             |
 | 19  |  A   | MKXOIHZNBL                       |
 | 19  |  B   | 17872                            |
 | 20  |  A   | 119                              |
 | 20  |  B   | 471                              |
 | 21  |  A   | 152                              |
 | 21  |  B   | 1956174                          |
 | 22  |  A   | 5538                             |
 | 22  |  B   | 2511090                          |
 | 23  |  A   | 5929                             |
 | 23  |  B   | 907                              |
 | 24  |  A   | 1868                             |
 | 24  |  B   | 1841                             |
 | 25  |  A   | 4225                             |
 | 25  |  B   | Happy AoC !                      |
  ===============================================
```

## [LICENSE](https://github.com/Average-user/adventofcode-clj-2017/tree/master/LICENSE)

``` text
MIT License

Copyright (c) 2017 Lucas Polymeris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
