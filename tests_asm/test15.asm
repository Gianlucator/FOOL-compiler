push 0
lhp
push -2
lfp
add
lw
sop
lfp
lfp
push f1A1
js
print
halt

f1A1:
cfp
lra
lfp
lfp
push g1A1
js
srv
sra
pop
sfp
lrv
lra
js

g1A1:
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
halt
