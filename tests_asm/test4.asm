push 0
lhp
push 66
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
nullprint
halt

uA:
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

uB:
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

sB:
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
pop
sfp
lrv
lra
js
