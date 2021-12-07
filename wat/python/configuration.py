token_header = {
    # Unique identifier of the token configuration
    'kid': "6102ad6c86792300351fd952",
}

# Public key generated as part of token configuration
public_key = '''-----BEGIN PUBLIC KEY-----
miibijanbgkqhkig9w0baqefaaocaq8amiibcgkcaqea6nxbx
mi.............................................70
d1.######..#.....#.######..#.......###..#####..k7
kv.#.....#.#.....#.#.....#.#........#..#.....#.zh
zc.######..#.....#.######..#........#..#.......72
hg.#.......#.....#.#.....#.#........#..#.....#.ry
zh.#........#####..######..#######.###..#####..j0
mi.............................................t9
d1.#....#.#######.#.....#......................70
kv.#..#...#.........#.#........................k7
zc.###....#####......#.........................zh
hg.#..#...#..........#.........................2r
zh.#....#.#######....#.........................yj
zq.............................................0t
miibijanbgkqhkig9w0baqefaaocaq8amiibcgkcaqea6nxbx
-----END PUBLIC KEY-----
'''

# Sample of the Filter object
# Please refer to documentation for details
# https://sisense.dev/reference/js/metadata-item.html
# https://sisense.dev/reference/jaql/
sampleFltObject = {
    "jaql": {
        "table": "Commerce",
        "column": "Condition",
        "dim": "[Commerce.Condition]",
        "datatype": "text",
        "filter": {
            "members": [
                "New"
            ]
        },
        "title": "Condition",
    }
}

token_payload = {
    # Sisense user id in that is associated with the token
    'sub': "60c8a1513dc0ba002c5f8816",
    # Time to live for the token. The timestamp at which the token will expire (not exists = infinite)
    'exp': 4475878357,
    # Token not before time, or the time before which the WAT will NOT be accepted. Measured as seconds since epoch
    'nbf': 1475878357,
    # The list of permissions that the token grants
    'grants': {
        # List of Dashboard IDs of the assets allowed to be accessed via token
        'res': ["dashboards/60ec626ffd920200358e7766"],
        # Dashboard / Widget filters
        'flt': [sampleFltObject],
        # Permissions set / grants (for dashboard/widget context)
        # Possible values ["filter", "export"]
        'prm': ["filter"]
    }
}
