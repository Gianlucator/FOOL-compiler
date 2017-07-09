push 0
push 1
lhp
sw
push 1
lhp
add
shp
lhp
push 1
lhp
sw
push 1
lhp
add
shp
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
push -3
lfp
add
lw
sop
lfp
lfp
push f1B1
js
add
print
halt

f1A1:
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

f1B1:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js
halt
