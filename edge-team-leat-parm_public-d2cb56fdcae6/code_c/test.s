asrs	r1, r2
asrs	r4, r3, #5
adds	r2, r1, r3
adds	r1, r4, #2
adds	r1, #16
subs	r2, r1, r3
subs	r1, r4, #2
subs	r1, #16
movs	r3, #45
adcs	r5, r0
sbcs	r1, r2
rors	r1, r4
tst	r3, r5
cmn	r1, r1
bics	r2, r6
mvns	r5, r7
str	r0, [sp, #48]
str	r1, [sp]
add	sp, #56
sub	sp, #21
movs	r1, r3
movs	r3, #15