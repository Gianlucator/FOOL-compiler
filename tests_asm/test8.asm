push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 13
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
push kB
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
sfp
lrv
lra
js

kA:
cfp
lra
push 5
srv
sra
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
sfp
lrv
lra
js

kB:
cfp
lra
push 6
srv
sra
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
sfp
lrv
lra
js
