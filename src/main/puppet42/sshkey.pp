define sshkey (
  $name         , # (namevar) The host name that the key is associated...
  $ensure       , # The basic property that the resource should be...
  $host_aliases , # Any aliases the host might have.  Multiple...
  $key          , # The key itself; generally a long string of...
  $provider     , # The specific backend to use for this `sshkey...
  $target       , # The file in which to store the ssh key.  Only...
  $type         , # The encryption type used.  Probably ssh-dss or...
  # ...plus any applicable metaparameters.
){}
