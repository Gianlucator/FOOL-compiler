push 0
push 1
lhp
sw
push 1
lhp
add
shp
lhp
lhp
sw
push 1
lhp
add
shp
push 2
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
push ooo3C1
js
print
halt

ooo3C1:
cfp
lra
push -2
lop
add
lw
sop
lfp
lfp
push get3A1
js
srv
sra
pop
sfp
lrv
lra
js

get3A1:
cfp
lra
push 44
srv
sra
pop
sfp
lrv
lra
js

get3B1:
cfp
lra
push 555
srv
sra
pop
sfp
lrv
lra
js
halt
