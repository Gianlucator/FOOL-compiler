push 0
lhp
lhp
push -3
lfp
add
lw
sop
lfp
push -2
lfp
add
lw
lfp
push g1D1
js
print
halt

g1C1:
cfp
lra
push 1
srv
sra
pop
pop
sfp
lrv
lra
js

g1D1:
cfp
lra
push 2
srv
sra
pop
pop
sfp
lrv
lra
js
halt
