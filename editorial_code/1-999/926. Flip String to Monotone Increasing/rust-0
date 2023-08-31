use std::cmp;

impl Solution {
    pub fn min_flips_mono_incr(s: String) -> i32 {
        let mut m = 0;
        for c in s.chars() {
            if (c == '0') {
                m += 1
            }
        }
        let mut ans = m;
        for c in s.chars() {
            if (c == '0') {
                m -= 1;
                ans = cmp::min(ans, m);
            } else {
                m += 1;
            }
        }
        ans
    }
}