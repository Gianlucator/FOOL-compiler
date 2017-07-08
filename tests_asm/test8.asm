push 0
push 2
lhp
sw
push 1
lhp
add
shp
push 0
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
push kB11
js
print
halt

uA11:
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

kA11:
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

uB11:
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

kB11:
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

sB11:
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
