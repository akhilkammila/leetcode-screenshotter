use std::cmp;

impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        let mut ans = 0;
        let mut num = 0;
        for c in s.chars() {
            if (c == '0') {
                ans = cmp::min(num, ans + 1)
            } else {
                num += 1
            }
        }
        ans
    }
}