<h2><a href="https://www.geeksforgeeks.org/problems/recursive-sequence1611/1">Recursive Sequence</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given an integer <strong>n</strong>, compute the value of <strong>F(n)</strong> where F(n) is defined as:<strong> </strong>F(n) = (1) + (2×3) + (4×5×6) + (7×8×9×10) + …up to n terms.&nbsp;</span></p>
<p><span style="font-size: 14pt;"><span style="font-size: 18.6667px;"><strong>Note: </strong>As the answer can be very large, return the answer modulo 10<sup>9</sup>+7.</span></span></p>
<p><strong><span style="font-size: 18px;">Examples:</span></strong></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> n = 5
<strong>Output:</strong> 365527
<strong>Explanation:</strong> F(5) = 1 + 2*3 + 4*5*6 + 7*8*9*10 + 11*12*13*14*15 = 365527.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input:</strong> n = 7
<strong>Output:</strong> 6997165<br><strong>Explanation:</strong> F(7) = 1 + 2*3 + 4*5*6 + 7*8*9*10 + 11*12*13*14*15 + 16*17*18*19*20*21 + 22*23*24*25*26*27*28 = 6006997207.<br>6006997207 % 10<sup>9</sup>+7 = 6997165</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 ≤ n ≤ 100</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>MAQ Software</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Mathematics</code>&nbsp;<code>Recursion</code>&nbsp;