push 0
push 2
lhp
sw
push 1
lhp
add
shp
push -2
lfp
add
lw
shp
push uB
lw
js
print
halt

uA:
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

uB:
cfp
lra
push 0
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
push 3
srv
sra
pop
pop
sfp
lrv
lra
js
