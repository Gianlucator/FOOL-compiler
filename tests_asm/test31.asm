push 0
lhp
push -2
lfp
add
lw
sop
lfp
lfp
push u1A1
js
print
halt

u1A1:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

s1B1:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js
halt
