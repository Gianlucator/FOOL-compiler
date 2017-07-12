push 0
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
push get3B1
js
push -3
lfp
add
lw
print
halt

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
